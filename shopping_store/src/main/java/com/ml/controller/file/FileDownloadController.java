
package com.ml.controller.file;

import java.io.File;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("file")
public class FileDownloadController {
	private static Log logger = LogFactory.getLog(FileDownloadController.class);

	@RequestMapping(value = "/download1")
	public String download1(ModelMap modelMap,
			@RequestParam("path") String srcPath,
			@RequestParam("fileName") String fileName,
			@RequestParam("fileType") String fileType,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		fileName = URLDecoder.decode(fileName, "UTF-8");
		logger.info("**********************************��ʼ�����ļ�********************************");
		logger.info("**********************************��������path��" + srcPath+ "********************************");
		logger.info("**********************************��������fileName��" + fileName + "********************************");
		logger.info("**********************************��������fileType��" + fileType + "********************************");
		modelMap.put("path", srcPath);
		modelMap.put("fileName", fileName);
		modelMap.put("fileType", fileType);
		return "fileDownLoad";
	}


	
	
	@RequestMapping(value = "/download2")
	public ResponseEntity<byte[]> download2(
			@RequestParam("path") String srcPath,
			@RequestParam("fileName") String fileName,
			@RequestParam("fileType") String fileType) throws Exception {
		fileName = URLDecoder.decode(fileName, "UTF-8");
		logger.info("**********************************��ʼ�����ļ�********************************");
		logger.info("**********************************��������path��" + srcPath+ "********************************");
		logger.info("**********************************��������fileName��"+ fileName + "********************************");
		logger.info("**********************************��������fileType��"+ fileType + "********************************");
		File file = new File(srcPath + File.separator + fileName);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attchement",
				new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}
}
