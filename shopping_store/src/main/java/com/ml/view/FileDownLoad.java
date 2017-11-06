/**
 * FileDownLoad.java created on 2014��12��23�� ����9:45:03
 * Copyright (c) 2014 by xliang
 */
package com.ml.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

/**
 * @author Administrator
 *
 */
public class FileDownLoad extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) {
		OutputStream output = null;
		FileInputStream fileIn = null;
		String path = (String) map.get("path");
		String fileName = (String) map.get("fileName");
		String fileType = (String) map.get("fileType");
		try {
			response.setContentType(fileType + ";charset=UTF-8");
			output = response.getOutputStream();
			if (path == null || "".equals(path)) {
				output.write("�ļ�������".getBytes());
			} else {
				File file = new File(path + File.separator + fileName);
				// ���ļ�����������ʱ����������룬ͨ��new
				// String(fileName.getBytes("utf-8"),"ISO8859-1")ת��
				response.setHeader(
						"Content-Disposition",
						"attachment;filename="
								+ new String(fileName.getBytes("utf-8"),
										"ISO8859-1"));
				fileIn = new FileInputStream(file);
				int i = 0;
				byte[] buffer = new byte[1024];
				while ((i = fileIn.read(buffer)) != -1) {
					output.write(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileIn != null) {
				try {
					fileIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
