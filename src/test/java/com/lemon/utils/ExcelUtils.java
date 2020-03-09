package com.lemon.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.record.ObjectProtectRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.google.common.base.Objects;
import com.lemon.pojo.API;
import com.lemon.pojo.Case;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import javassist.bytecode.stackmap.TypeData.ClassName;

public class ExcelUtils {
	

	public static <T> List<T> read(String filePath, int sheetIndex, Class<T> className) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(filePath);
			ImportParams params = new ImportParams();
			params.setNeedVerify(true);
			params.setStartSheetIndex(sheetIndex);
			// 工具解析excel封装成list对象
			List<T> list = ExcelImportUtil.importExcel(fis, className, params);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(fis);

		}
          return null;
	}

	// public static Object[][] read(String filePath) {
	// Object[][] data = null;
	// FileInputStream fis = null;
	//
	// try {
	// // 1.读取excel文件
	// fis = new FileInputStream(filePath);
	// // 2.打开excel文件
	// Workbook workbook = WorkbookFactory.create(fis);
	// // 3.获取指定的sheet
	// Sheet sheet = workbook.getSheet("接口信息");
	// // 4.获取最大行
	// int lastRowNum = sheet.getLastRowNum();
	// data = new Object[lastRowNum][4];
	// // 5.遍历行
	// for (int i = 1; i <= lastRowNum; i++) {
	// Row row = sheet.getRow(i);
	// // 6.获取单元格的值
	// // 6.1 urlCell
	// Cell urlCell = row.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK);
	// urlCell.setCellType(CellType.STRING);
	// String urlValue = urlCell.getStringCellValue();
	// data[i - 1][0] = urlValue;
	// // 6.2 typeCell
	// Cell typeCell = row.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK);
	// typeCell.setCellType(CellType.STRING);
	// String typeValue = typeCell.getStringCellValue();
	// data[i - 1][2] = typeValue;
	// // 6.3 paramsCell
	// Cell paramsCell = row.getCell(5, MissingCellPolicy.CREATE_NULL_AS_BLANK);
	// paramsCell.setCellType(CellType.STRING);
	// String paramsValue = paramsCell.getStringCellValue();
	// data[i - 1][1] = paramsValue;
	//
	// // 6.4 ContentTypeCell
	// Cell contentTypeCell = row.getCell(6,
	// MissingCellPolicy.CREATE_NULL_AS_BLANK);
	// contentTypeCell.setCellType(CellType.STRING);
	// String contentTypeValue = contentTypeCell.getStringCellValue();
	// data[i - 1][3] = contentTypeValue;
	//
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// // finally用于关闭资源
	// } finally {
	//
	// close(fis);
	// }
	//
	// return data;
	// }

	private static void close(FileInputStream fis) {
		try {
			if (fis != null) {
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
