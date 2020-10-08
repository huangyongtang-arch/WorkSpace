package com;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @ClassName pdfTest
 * @Description TODO
 * @Author tommy
 * @Date 9/10/2020 9:36 PM
 **/
public class pdfTest {
    public static void main(String[] args) throws IOException, DocumentException, com.lowagie.text.DocumentException {
        System.out.println("/jar".substring(1));
        System.out.println(ResourceUtils.getURL(ResourceUtils.JAR_URL_PREFIX).getPath().substring(1) +
                ResourceUtils.getURL(ResourceUtils.FILE_URL_PREFIX).getPath()+ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX).getPath() + "images/pdf-background.png");
        System.out.println(pdfTest.class.getClassLoader().getResource("images/pdf-background.png").getPath());
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        // 将pdf文件先加水印然后输出
//        warterMark(new FileInputStream(new File("C:\\Users\\tommy\\Downloads\\Gson.pdf")), new FileOutputStream(new File("./out.pdf")), format.format(cal.getTime()) + "  下载使用人：" + "测试user");
//        addBackgroundImage(new FileInputStream(new File("C:\\Users\\tommy\\Downloads\\Gson.pdf")), new FileOutputStream(new File("./outP.pdf")));
    }

    public static void warterMark(FileInputStream fileInputStream, FileOutputStream fileOutputStream,
                                  String waterMark) {
        try {
            // 添加水印的时候,就已经在outputStream写入了
            PdfReader reader = new PdfReader(fileInputStream);
            Rectangle pageRect = null;
            PdfStamper stamper = new PdfStamper(reader, fileOutputStream);
            int total = reader.getNumberOfPages() + 1;
            PdfContentByte content;
            BaseFont base = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            int textH = 8;
            int textW = 20;
            PdfGState gs = new PdfGState();
            int interval = -5;
            for (int i = 1; i < total; i++) {
                pageRect = reader.getPageSizeWithRotation(i);
                content = stamper.getUnderContent(i);// 在内容上方加水印
                gs.setFillOpacity(0.2f);
                content.setGState(gs);
                content.beginText();
                content.setFontAndSize(base, 20);
                content.setTextMatrix(70, 200);
                // 设置文字大小
                content.setFontAndSize(base, textH);
                // 将内容显示在pdf底部
                for (int height = interval + textH; height < pageRect.getHeight(); height = height + textH * 3) {
                    for (int width = interval + textW; width < pageRect.getWidth() + textW; width = width + textW * 2) {
                        content.showTextAligned(Element.ALIGN_LEFT, waterMark, width - textW, height - textH, 30);
                    }
                }
                content.endText();
            }
            stamper.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


        /**
         *
         * pdf文件添加背景图片
         * @param fileInputStream  PDF文件输入流
         * @param fileOutputStream PDF文件输出流
         */
        public static void addBackgroundImage(FileInputStream fileInputStream, FileOutputStream fileOutputStream) {
            try {
                Image image = Image.getInstance(pdfTest.class.getClassLoader().getResource("image/pdf-background.png").getPath());
                image.scaleAbsolute(PageSize.A4.rotate());
                image.setAbsolutePosition(0, 0);
                PdfReader reader = new PdfReader(fileInputStream);
                PdfStamper stamper = new PdfStamper(reader, fileOutputStream);
                int total = reader.getNumberOfPages() + 1;
                PdfContentByte content;
                for (int i = 1; i < total; i++) {
                    content = stamper.getUnderContent(i);
                    content.addImage(image);
                }
                stamper.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
