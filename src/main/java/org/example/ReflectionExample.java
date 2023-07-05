package org.example;

/**
 * @author liushuaibiao
 * @date 2023/7/5 10:18
 */
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.entity.ClassInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReflectionExample {
    public static ClassInfo getPropertyNames(String classPath) {
        ClassInfo classInfo = new ClassInfo();
        List<String> propertyNames = new ArrayList();
        List<String> typeNames = new ArrayList();

        try {
            // 创建自定义类加载器
            ExternalClassLoader classLoader = new ExternalClassLoader();

            // 加载外部类
            Class<?> clazz = classLoader.loadClass(classPath);

            // 获取类的所有字段
            Field[] fields = clazz.getDeclaredFields();

            // 获取字段名称
            for (Field field : fields) {
                Class<?> type = field.getType();
                if (String.valueOf(type).equals("long")){
                    continue;
                }
                propertyNames.add(field.getName());
                typeNames.add(String.valueOf(type));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        classInfo.setPropertyNames(propertyNames);
        classInfo.setTypeNames(typeNames);
        return classInfo;
    }

    public static void main(String[] args) {
        // 外部类的路径
        String classPath = "/Users/liushuaibiao/Desktop/EntityToExcel/target/classes/org/example/target/Tar.class"; // 替换为你的外部类的路径



        // 创建工作簿
        Workbook workbook = new XSSFWorkbook();

        // 创建工作表
        Sheet sheet = workbook.createSheet("Data");

        // 获取类的属性名称
        ClassInfo classInfo = getPropertyNames(classPath);
        List<String> propertyNames = classInfo.getPropertyNames();
        //获取变量类型名称
        Object[] typeNames = classInfo.getTypeNames().toArray();

        Object[] properArray = propertyNames.toArray();
        for (int i = 0; i < properArray.length; i++) {
            // 创建行
            Row row = sheet.createRow(i);

            // 创建单元格
            Cell cell = row.createCell(0);
            Cell cell1 = row.createCell(1);
            cell.setCellValue(String.valueOf(properArray[i]));
            String str = String.valueOf(typeNames[i]);
            // 查找最后一个点的位置
            int lastIndex = str.lastIndexOf(".");

            if (lastIndex != -1 && lastIndex < str.length() - 1) {
                // 分割字符串并获取最后一部分
                String lastPart = str.substring(lastIndex + 1);
                cell1.setCellValue(lastPart);
            }
        }
        // 将数据写入文件
        try (FileOutputStream fileOut = new FileOutputStream("/Users/liushuaibiao/Desktop/output1.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel 文件写入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 自定义类加载器
    static class ExternalClassLoader extends ClassLoader {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                // 读取类文件的字节数组
                File file = new File(name);
                byte[] bytes = Files.readAllBytes(file.toPath());

                // 加载类
                return defineClass(null, bytes, 0, bytes.length);
            } catch (IOException e) {
                throw new ClassNotFoundException("Failed to load class: " + name, e);
            }
        }
    }
}

