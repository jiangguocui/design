package com.utils;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
/**
 * 抓屏工具
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: ND Co., Ltd.       </p>
 * <p>Create Time: 2016年10月12日           </p>
 * @author Administrator
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
public class CaptureScreenUtil {

    public static void captureScreen(String fileName) throws Exception {  

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
        Rectangle screenRectangle = new Rectangle(screenSize);  
        Robot robot = new Robot();  
        BufferedImage image = robot.createScreenCapture(screenRectangle);  
        ImageIO.write(image, "jpg", new File(fileName));  

     }  
    
    public static void main(String[] args) throws Exception {
        
        String fileName = "c://image_"+System.currentTimeMillis()+".jpg";
        CaptureScreenUtil.captureScreen(fileName);
    }
}
