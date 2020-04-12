package com.ch.cb_common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * md5工具类
 * @author lch
 * @date 2020/4/12
 */
@Slf4j
public class Md5Util {

    public static String md5(String text) {
        try {
            return DigestUtils.md5Hex(text);
        } catch (Exception e) {
            log.error("md5 text:{} exception:{}", text, e.getMessage(), e);
            return StringUtils.EMPTY;
        }
    }

    public static boolean md5(String text, String md5Value) {
        return md5(text).equalsIgnoreCase(md5Value);
    }

    /**
     * 对文件进行 MD5 加密
     *
     * @param file 待加密的文件
     * @return 文件加密后的 MD5 值
     * @throws IOException
     */
    public static String md5(File file) throws IOException {
        if (file == null) {
            return StringUtils.EMPTY;
        }
        FileInputStream is = null;
        try {
            is = new FileInputStream(file);
            return DigestUtils.md5Hex(is);
        } catch (Exception e) {
            log.error("md5 file:{} exception:{}", file.getName(), e.getMessage(), e);
            return StringUtils.EMPTY;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
