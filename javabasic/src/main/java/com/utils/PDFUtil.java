package com.utils;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 * @ClassName PDFUtil
 * @Description TODO
 * @Author tommy
 * @Date 9/10/2020 9:32 PM
 **/
public class PDFUtil {
    /**
     *
     * @param file pdf文件
     * @param path html存储路径
     */
    public static void toHTML(File file, String path) {
        StringBuffer buffer = new StringBuffer();
        FileOutputStream fos;
        PDDocument document;
        int size;
        BufferedImage image;
        FileOutputStream out;
        try {
            // 遍历处理pdf附件
            buffer.append("<!doctype html>\r\n");
            buffer.append("<head>\r\n");
            buffer.append("<meta charset=\"UTF-8\">\r\n");
            buffer.append(
                    "<script type='text/javascript'>document.oncontextmenu = function(){alert('当前页面不能使用右键！');return false;}</script>\r\n");
            buffer.append("</head>\r\n");
            buffer.append("<body style=\"background-color:gray;\">\r\n");
            buffer.append("<style>\r\n");
            buffer.append(
                    "img {background-color:#fff; text-align:center; width:100%; max-width:100%;margin-top:6px;}\r\n");
            buffer.append(".img-cont{width: 100%;overflow: hidden;}\r\n");
            buffer.append("</style>\r\n");
            buffer.append("<div class='img-cont'>\r\n");
            document = new PDDocument();
            // PDF转换成HTML保存的文件夹
            File destDirFile = new File(path);
            if (!destDirFile.exists()) {
                destDirFile.mkdir();
            }
            // PDF网页引用图片文件夹
            String imgPath = "images";
            File imageDir = new File(destDirFile, imgPath);
            if (!imageDir.exists()) {
                imageDir.mkdir();
            }
            // 加载pdf文件
            document = PDDocument.load(file);
            size = document.getNumberOfPages();
            PDFRenderer reader = new PDFRenderer(document);
            for (int i = 0; i < size; i++) {
                image = reader.renderImage(i, 1.5f);
                // 生成图片,保存位置
                out = new FileOutputStream(imageDir.getPath() + "/" + "image_" + i + ".png");
                ImageIO.write(image, "png", out); // 使用png的清晰度
                // 将图片路径追加到网页文件里
                buffer.append("<img src='./" + imgPath + "/image" + "_" + i + ".png'/>\r\n");
                image = null;
                out.flush();
                out.close();
            }
            reader = null;
            document.close();
            buffer.append("</div>\r\n");
            buffer.append("</body>\r\n");
            buffer.append("</html>");
            String htmlFilename = file.getName();
            // 生成网页文件
            fos = new FileOutputStream(
                    destDirFile.getPath() + "/" + htmlFilename.substring(0, htmlFilename.lastIndexOf(".")) + ".html");
            fos.write(buffer.toString().getBytes());
            fos.flush();
            fos.close();
            buffer.setLength(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * PDF打水印
     *
     * @param fileInputStream  PDF文件输入流
     * @param fileOutputStream PDF文件输出流
     * @param waterMark        水印文本
     */
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
}
