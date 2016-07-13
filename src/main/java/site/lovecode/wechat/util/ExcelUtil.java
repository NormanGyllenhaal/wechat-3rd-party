/**
 * ExcelUtil.java cn.vko.core.common.util Copyright (c) 2014,
 * .
 */

package site.lovecode.wechat.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * excel辅助类
 * <p>
 * 
 * 
 * @author wanglulu
 * @date 2014-12-8
 * @version 1.0.0
 */
public class ExcelUtil {

	/**
	 * 读取Excel表格表头的内容
	 * <p>
	 *
	 * @param row
	 *            头行内容
	 * @param colNum
	 *            总列数
	 * @return
	 */
	public static String[] readExcelTitle( HSSFRow row, int colNum ) {

		String[] title = new String[colNum];
		for ( int i = 0 ; i < colNum ; i++ ) {
			title[i] = getStringCellValue(row.getCell(i)).trim();
		}
		return title;
	}


	/**
	 * 获取单元格数据内容为字符串类型的数据
	 * <p>
	 *
	 * @param cell
	 *            Excel单元格
	 * @return String 单元格数据内容
	 */
	public static String getStringCellValue( HSSFCell cell ) {

		String strCell = "";
		if ( cell != null ) {
			switch ( cell.getCellType() ) {
				case HSSFCell.CELL_TYPE_STRING :
					strCell = cell.getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_NUMERIC :
					DecimalFormat df = new DecimalFormat("0.0");
					strCell = df.format(cell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN :
					strCell = String.valueOf(cell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_FORMULA :
					strCell = String.valueOf(cell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_BLANK :
					break;
				default:
					break;
			}
		}
		if ( strCell == null || strCell.equals("") ) { return ""; }
		return strCell.trim();
	}


	/**
	 * sheet 合并单元格
	 * 
	 * <p>
	 *
	 * @param sheet
	 * @param firstRow
	 *            开始行
	 * @param lastRow
	 *            结束列
	 * @param firstCol
	 *            开始行
	 * @param lastCo
	 *            结束列
	 */
	public static void addRegion( HSSFSheet sheet, int firstRow, int lastRow, int firstCol, int lastCol ) {
		CellRangeAddress range = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
		sheet.addMergedRegion(range);
	}


	public static HSSFCellStyle getDefulatStyle( HSSFWorkbook wb ) {
		HSSFCellStyle style = wb.createCellStyle();// cell样式
		// 设置单元格上、下、左、右的边框线
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 设置单元格字体居中（左右方向）
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 设置字体显示居中(上下方向)

		return style;
	}


	/**
	 * 为excel一行赋值
	 * 
	 * <p>
	 *
	 * @param row
	 * @param cellValues
	 *            值
	 * @param style
	 *            样式
	 */
	public static void addRow( HSSFRow row, List<String> cellValues, HSSFCellStyle style ) {
		for ( int i = 0 ; i < cellValues.size() ; i++ ) {
			String cellValue = cellValues.get(i);
			HSSFCell headerCell = row.createCell(i);
			headerCell.setCellValue(cellValue);
			headerCell.setCellStyle(style);
		}
	}


	public static void addRow( HSSFRow row, List<Object> cellValues ) {
		for ( int i = 0 ; i < cellValues.size() ; i++ ) {
			Object cellValue = cellValues.get(i);
			HSSFCell headerCell = row.createCell(i);
			if ( cellValue instanceof String ) {
				headerCell.setCellValue((String) cellValue);
			} else if ( cellValue instanceof Integer ) {
				headerCell.setCellValue((Integer) cellValue);
			} else if ( cellValue instanceof Long || cellValue instanceof Double || cellValue instanceof BigDecimal ) {
				headerCell.setCellValue(new Double(cellValue.toString()));
			}
		}
	}


	/**
	* 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
	* <p>
	* @author LHX
	* 
	* @param file 读取数据的源Excel
	* @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
	* 
	* @return 读出的Excel中数据的内容
	*/
	@SuppressWarnings( "deprecation" )
	public static String[][] getData( String file, int ignoreRows ) throws FileNotFoundException, IOException {
		List<String[]> result = new ArrayList<String[]>();
		int rowSize = 0;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		// InputStream in = file.getInputStream();
		// 打开HSSFWorkbook
		POIFSFileSystem fs = new POIFSFileSystem(in);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFCell cell = null;
		for ( int sheetIndex = 0 ; sheetIndex < 1 /*wb.getNumberOfSheets()*/; sheetIndex++ ) {
			HSSFSheet st = wb.getSheetAt(sheetIndex);
			// 第一行为标题，不取
			for ( int rowIndex = ignoreRows ; rowIndex <= st.getLastRowNum() ; rowIndex++ ) {
				HSSFRow row = st.getRow(rowIndex);
				if ( row == null ) {
					continue;
				}
				int tempRowSize = row.getLastCellNum() + 1;
				if ( tempRowSize > rowSize ) {
					rowSize = tempRowSize;
				}
				String[] values = new String[rowSize];
				Arrays.fill(values, "");
				boolean hasValue = false;
				for ( short columnIndex = 0 ; columnIndex <= row.getLastCellNum() ; columnIndex++ ) {
					String value = "";
					cell = row.getCell(columnIndex);
					if ( cell != null ) {
						// 注意：一定要设成这个，否则可能会出现乱码
						// cell.setsetEncoding(HSSFCell.ENCODING_UTF_16);
						switch ( cell.getCellType() ) {
							case HSSFCell.CELL_TYPE_STRING :
								value = cell.getStringCellValue();
								break;
							case HSSFCell.CELL_TYPE_NUMERIC :
								if ( HSSFDateUtil.isCellDateFormatted(cell) ) {
									Date date = cell.getDateCellValue();
									if ( date != null ) {
										value = new SimpleDateFormat("yyyy-MM-dd").format(date);
									} else {
										value = "";
									}
								} else {
									value = new DecimalFormat("0").format(cell.getNumericCellValue());
								}
								break;
							case HSSFCell.CELL_TYPE_FORMULA :
								// 导入时如果为公式生成的数据则无值
								if ( !cell.getStringCellValue().equals("") ) {
									value = cell.getStringCellValue();
								} else {
									value = cell.getNumericCellValue() + "";
								}
								break;
							case HSSFCell.CELL_TYPE_BLANK :
								break;
							case HSSFCell.CELL_TYPE_ERROR :
								value = "";
								break;
							case HSSFCell.CELL_TYPE_BOOLEAN :
								value = (cell.getBooleanCellValue() == true ? "Y" : "N");
								break;
							default:
								value = "";
						}
					}
					if ( columnIndex == 0 && value.trim().equals("") ) {
						break;
					}
					values[columnIndex] = rightTrim(value);
					hasValue = true;
				}

				if ( hasValue ) {
					result.add(values);
				}
			}
		}
		in.close();
		String[][] returnArray = new String[result.size()][rowSize];
		for ( int i = 0 ; i < returnArray.length ; i++ ) {
			returnArray[i] = result.get(i);
		}
		return returnArray;
	}

	 /**
     * title:sheet标题
     * exportFileName:文件名
     * list:数据
     * @author LHX
     * @param list
     * @return
     * @throws FileNotFoundException 
     */
    @SuppressWarnings("deprecation")
	public static HSSFWorkbook getExcelFile(String title,String exportFileName,List<?> list) throws FileNotFoundException {
        HSSFWorkbook wb = null;//要导出的流
        try {
            wb = new HSSFWorkbook();   
            HSSFSheet sheet = wb.createSheet(title); //创建sheet
           // 设置表格默认列宽度为15个字节  
            sheet.setDefaultColumnWidth((short) 15); 
            @SuppressWarnings("unused")
            HSSFRow headRow= sheet.createRow(0);//获取行
                if(list!=null&&list.size()>0){
                    //封装表头
                    HSSFRow row= sheet.createRow(0);
                    @SuppressWarnings("unchecked")
                    Map<String, ?> map1=(Map<String, ?>) list.get(0);
                    Iterator<String> iter1 = map1.keySet().iterator();
                    int cell1=0;
                    while (iter1.hasNext()) {
                        String   key = iter1.next();
                        String   value=key;//key 就是 标题名称
                        addCell(row, value, cell1);
                        cell1++;
                    }
                    int k=1;//数据起始行数

                    for(int i=0;i<list.size();i++){
                        //循环数据      调用 getFieldMap方法  得到 map对象  key:bean.属性  value:bean.get属性
                        @SuppressWarnings("unchecked")
                        Map<String, ?> map= (Map<String, ?>)list.get(i);
                        HSSFRow row1= sheet.createRow(k);
                        Iterator<String> iter = map.keySet().iterator();
                        int cell=0;
                        while (iter.hasNext()) {
                            String   key = iter.next();
                            String  value = map.get(key)!=null?map.get(key).toString():"";
                            addCell(row1, value, cell);
                            cell++;
                        }
                        k++;
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } 
        return wb;
    } 


    /**
     * 增加列
     * @param row
     * @param value
     * @param col
     */
    public static void addCell(HSSFRow row, Object value, int col) {
        HSSFCell cell = row.createCell(col);

        switch (col) {
        case 33:
            double num;
            try {
                num = Double.parseDouble((String) value);
            } catch (Exception e) {
                num = 0;
            }
            cell.setCellValue(num);
            break;
        default:
            if (value instanceof Date) {
                cell.setCellValue((Date) value);
            } else {
                cell.setCellValue(new HSSFRichTextString((String) value));
            }
        }
    }

	/**
	 * 去掉字符串右边的空格
	 * @param str 要处理的字符串
	 * @return 处理后的字符串
	 */
	public static String rightTrim( String str ) {
		if ( str == null ) { return ""; }
		int length = str.length();
		for ( int i = length - 1 ; i >= 0 ; i-- ) {
			if ( str.charAt(i) != 0x20 ) {
				break;
			}
			length--;
		}
		return str.substring(0, length);
	}
}
