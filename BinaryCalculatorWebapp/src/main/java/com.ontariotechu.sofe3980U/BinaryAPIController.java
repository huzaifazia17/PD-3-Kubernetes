package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/add")
	public String addString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
			@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return Binary.add(number1, number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(
			@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
			@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return new BinaryAPIResult(number1, "add", number2, Binary.add(number1, number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

	@GetMapping("/OR")
	public String ORString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
			@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return Binary.OR(number1, number2).getValue();
		// http://localhost:8080/OR?operand1=111&operand2=1010
	}

	@GetMapping("/OR_json")
	public BinaryAPIResult ORJSON(
			@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
			@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return new BinaryAPIResult(number1, "OR", number2, Binary.OR(number1, number2));
		// http://localhost:8080/OR_json?operand1=111&operand2=1010
	}

	@GetMapping("/AND")
	public String ANDString(
			@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
			@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return Binary.AND(number1, number2).getValue();
		// http://localhost:8080/AND?operand1=111&operand2=1010
	}

	@GetMapping("/AND_json")
	public BinaryAPIResult ANDJSON(
			@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
			@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return new BinaryAPIResult(number1, "AND", number2, Binary.AND(number1, number2));
		// http://localhost:8080/AND_json?operand1=111&operand2=1010
	}

	@GetMapping("/multiply")
	public String multplyString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
			@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return Binary.multiply(number1, number2).getValue();
		// http://localhost:8080/multiply?operand1=1111&operand2=1010
	}

	@GetMapping("/multiply_json")
	public BinaryAPIResult multiplyJSON(
			@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
			@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return new BinaryAPIResult(number1, "multiply", number2, Binary.multiply(number1, number2));
		// http://localhost:8080/multiply_json?operand1=1111&operand2=1010
	}
}