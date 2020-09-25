package com.example.quickblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//กำหนดให้ class เป็น Controller
@Controller
public class MainController {
	// ทำ URL Mapping
	@RequestMapping(value = "/", method = RequestMethod.GET)

	// แสดงผลที่หน้าเว็ป
	@ResponseBody

	public String index() {
		return "My Quick Blog";
	}

	@RequestMapping("/about")
	@ResponseBody
	public String about() {
		return "About";
	}

	@RequestMapping("/View")
	@ResponseBody
	public String view() {
		return "View Data";
	}

	// แบบย่อ
	@GetMapping("/service")
	@ResponseBody
	public String service() {
		return "service pages";
	}

	/*
	 * // การส่งค่าไปที่หน้า view
	 * 
	 * @GetMapping("/contact") public String contact() { return "contacts"; //
	 * ชื่อไฟล์ใน view ไม่ต้องใส่นามสกุล }
	 */

	// การส่งตัวแปร
	/*
	 * @GetMapping("/contact") public String contact(ModelMap model) { String hello
	 * = "1234"; model.addAttribute("textHello", hello); return "contacts"; //
	 * ชื่อไฟล์ใน view ไม่ต้องใส่นามสกุล }
	 */

	// การรับส่งค่าผ่าน URL
	@GetMapping("/contact")
	public String contact(ModelMap model, @RequestParam(defaultValue = "John") String name) {
		String hello = "1234";
		model.addAttribute("textHello", hello);
		model.addAttribute("fullName", name);
		return "contacts"; // ชื่อไฟล์ใน view ไม่ต้องใส่นามสกุล
	}

}
