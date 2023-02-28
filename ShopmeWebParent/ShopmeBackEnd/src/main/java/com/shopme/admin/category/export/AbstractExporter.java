package com.shopme.admin.category.export;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;

public class AbstractExporter {

	public void setResponseHeader(HttpServletResponse response,String contentType,String fileExtension) throws IOException {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

		String timeStamp = df.format(new Date());
		String fileName = "categories_" + timeStamp + fileExtension;

		response.setContentType(contentType);
		String headerKey = "Content-Disposition";
		String headerValue = "attatchment;filename=" + fileName;
		response.setHeader(headerKey, headerValue);

		
	}
}
