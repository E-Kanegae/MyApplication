package com.example.ek.recordapp.web.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ek.recordapp.domain.bean.book.BookInfo;
import com.example.ek.recordapp.domain.service.book.BookInfoSearchResult;
import com.example.ek.recordapp.domain.service.book.BookInfoService;
import com.example.ek.recordapp.web.book.BookInfoForm.Create;

/**
 * record-app
 * com.example.ek.recordapp.web.book.BookInfoController.java
 *
 * ブックリスト機能向けのContorllerクラス
 *
 * @author E-Kanegae
 *
 */
@Controller
@RequestMapping("book")
public class BookInfoController {

	@Autowired
	private BookInfoService service;

	@Autowired
	private BookInfoHelper helper;
	
	@Autowired
	private Mapper mapper;

	@ModelAttribute("bookInfoForm")
	public BookInfoForm addBookInfoForm(Model model) {
		return ObjectUtils.isEmpty(model.getAttribute("bookInfoForm")) == true ? new BookInfoForm()
				: (BookInfoForm) model.getAttribute("bookInfoForm");
	}

	@ModelAttribute("bookCategory")
	public List<String> addBookCategory(Model model) {
		return BOOK_CATEGORY;
	}

	/**
	 * 書籍一覧画面を返却する処理
	 * @param model
	 * @return 書籍一覧画面
	 */
	@GetMapping("listAll")
	public String listall(Model model) {
		List<BookInfo> bookInfoList = service.listAll();
		model.addAttribute("booklist", CollectionUtils.isEmpty(bookInfoList) ? null : bookInfoList);
		return "book/booklist";
	}

	/**
	 * 書籍登録画面を返却する処理
	 * @param model
	 * @return 書籍登録画面
	 */
	@GetMapping("register")
	public String register(Model model) {
		return "book/book_registry";
	}

	@GetMapping("list")
	public String list(Model model) {
		return null;
	}

	@GetMapping("detail")
	public String detail() {
		return null;

	}

	/**
	 * 書籍を登録し、登録後、一覧画面に遷移する処理
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return 書籍一覧画面
	 */
	@PostMapping(value = "create")
	public String create(@Validated({ Create.class, Default.class }) BookInfoForm form, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("bindingResult", bindingResult);
			return register(model);
		}
		BookInfo input = mapper.map(form, BookInfo.class);
		service.create(input);

		return listall(model);
	}

	@PostMapping("update")
	public String update() {
		return null;
	}

	@PostMapping("delete")
	public String delete() {
		return null;
	}

	/**
	 * 書籍候補をBooksAPIから取得する処理
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return
	 *
	 */
	@GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  List<BookCandidate> searchCandidtate(@Validated BookInfoForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("bindingResult", bindingResult);
			// TODO: ExceptionHandlerに処理を移譲する。
		}
		List<BookInfoSearchResult> result = service.searchBookInfoCandidate(
				form.getIsbn() == null ? null : form.getIsbn().toString(), form.getFullName(), form.getAuthor());
		
		return CollectionUtils.isEmpty(result) ? null : helper.searchResults2Candidates(result);
	}

	/**
	 * ジャンルのリスト
	 */
	private static final List<String> BOOK_CATEGORY = new ArrayList<String>(
			Arrays.asList(
					"評論",
					"歴史・時代小説",
					"SF・ホラー・ファンタジー",
					"ミステリー・サスペンス",
					"語学",
					"家庭医学",
					"健康",
					"妊娠・出産・子育て",
					"介護",
					"住まい・インテリア",
					"クッキング",
					"グルメ",
					"資格",
					"法律関連",
					"コンピュータ・情報処理",
					"医療・看護",
					"アート",
					"投資",
					"経営",
					"ビジネス・経済",
					"社会・政治",
					"税金",
					"その他"));

}
