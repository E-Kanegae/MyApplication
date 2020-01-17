package com.example.ek.recordapp.web.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * record-app
 * com.example.ek.recordapp.web.sample.photoSampleController.java
 *
 * MDBootstrapのサンプル写真素材一覧画面への画面遷移を記述するControllerクラス
 *
 * @author E-kanegae
 *
 */
@Controller
@RequestMapping("photoSamples")
public class PhotoSampleController {

	@GetMapping("listAll")
	public String listAll(Model model) {
		model.addAttribute("urls", mkDoms());
		return "photoSamples/photoSamples";
	}

	private static final String URL_PREFIX = "https://mdbootstrap.com/img/Photos/Horizontal/Nature/12-col/img%20(";
	private static final String URL_SUFFIX = ").jpg";
	private static final String FIRST_COLUMN_PREFIX = "<div class=\"row mb-2\"><div class=\"col-3\"><img src=\"";
	private static final String FIRST_COLUMN_SUFFIX = "\" class=\"img-fluid\"></div>";
	private static final String MIDDLE_COLUMN_PREFIX = "<div class=\"col-3\"><img src=\"";
	private static final String MIDDLE_COLUMN_SUFFIX = "\" class=\"img-fluid\"></div>";
	private static final String LAST_COLUMN_PREFIX = "<div class=\"col-3\"><img src=\"";
	private static final String LAST_COLUMN_PSUFFIX = "\" class=\"img-fluid\"></div></div>";

	private List<String> mkDoms() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 130; i++) {
			if(i % 4 == 0) {
				list.add(FIRST_COLUMN_PREFIX + URL_PREFIX + Integer.valueOf(i + 1).toString() + URL_SUFFIX + FIRST_COLUMN_SUFFIX);
			}else if (i % 4 == 3) {
				list.add(LAST_COLUMN_PREFIX + URL_PREFIX + Integer.valueOf(i + 1).toString() + URL_SUFFIX + LAST_COLUMN_PSUFFIX);
			}else {
				list.add(MIDDLE_COLUMN_PREFIX + URL_PREFIX + Integer.valueOf(i + 1).toString() + URL_SUFFIX + MIDDLE_COLUMN_SUFFIX);
			}
			
		}
		return list;
	}

}
