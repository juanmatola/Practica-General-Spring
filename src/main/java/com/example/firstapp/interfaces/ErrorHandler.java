package com.example.firstapp.interfaces;

import org.springframework.ui.ModelMap;

public interface ErrorHandler {
	public String errorHandle(Exception e, ModelMap model);
}
