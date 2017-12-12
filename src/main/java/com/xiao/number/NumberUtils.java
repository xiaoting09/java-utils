package com.xiao.number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * 数字相关工具类
 *
 * @author xt
 */
public class NumberUtils {
    /**
     * 两位小数
     */
    private static final int DEFAULT_SCALE = 2;
    /**
     * 四舍五入
     */
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    /**
     * 将整型数据格式化为指定长度的字符串
     *
     * @param num
     * @param length
     * @return
     */
    public static final String format(int num, int length) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(length);
        nf.setMaximumIntegerDigits(length);
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(0);

        String result = nf.format(num);
        return result;
    }

    /**
     * 格式化小数长度
     *
     * @param num
     * @param fractionDigits
     * @return
     */
    public static final String formatFraction(double num, int fractionDigits) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(fractionDigits);
        nf.setMaximumFractionDigits(fractionDigits);

        String result = nf.format(num);
        return result;
    }

    /**
     * 加法(a + b)
     *
     * @param a
     * @param b
     * @return
     */
    public static final Double add(String a, String b) {
        BigDecimal aBD = new BigDecimal(a);
        BigDecimal bBD = new BigDecimal(b);
        BigDecimal cBD = aBD.add(bBD);
        return cBD.doubleValue();
    }

    /**
     * 加法(a + b)
     *
     * @param a
     * @param b
     * @return
     */
    public static final Double add(double a, double b) {
        return add(String.valueOf(a), String.valueOf(b));
    }

    /**
     * 减法(a - b)
     *
     * @param a
     * @param b
     * @return
     */
    public static final Double subtract(String a, String b) {
        BigDecimal aBD = new BigDecimal(a);
        BigDecimal bBD = new BigDecimal(b);
        BigDecimal cBD = aBD.subtract(bBD);
        return cBD.doubleValue();
    }

    /**
     * 减法(a - b)
     *
     * @param a
     * @param b
     * @return
     */
    public static final Double subtract(double a, double b) {
        return subtract(String.valueOf(a), String.valueOf(b));
    }

    /**
     * 乘法(a * b)
     *
     * @param a
     * @param b
     * @return
     */
    public static final Double multiply(String a, String b) {
        BigDecimal aBD = new BigDecimal(a);
        BigDecimal bBD = new BigDecimal(b);
        BigDecimal cBD = aBD.multiply(bBD);
        return cBD.doubleValue();
    }

    /**
     * 乘法(a * b)
     *
     * @param a
     * @param b
     * @return
     */
    public static final Double multiply(double a, double b) {
        return multiply(String.valueOf(a), String.valueOf(b));
    }

    /**
     * 除法(a / b)
     *
     * @param a
     * @param b
     * @return
     */
    public static final Double divide(double a, double b) {
        return divide(a, b, DEFAULT_SCALE);
    }

    /**
     * 除法(a / b)，并设置精度
     *
     * @param a
     * @param b
     * @param scale
     * @return
     */
    public static final Double divide(double a, double b, int scale) {
        return divide(a, b, scale, DEFAULT_ROUNDING_MODE);
    }

    /**
     * 除法(a / b)，并设置精度和舍入方式
     *
     * @param a
     * @param b
     * @param scale
     * @param roundingMode
     * @return
     */
    public static final Double divide(String a, String b, int scale, RoundingMode roundingMode) {
        BigDecimal aBD = new BigDecimal(a);
        BigDecimal bBD = new BigDecimal(b);
        BigDecimal cBD = aBD.divide(bBD, scale, roundingMode);
        return cBD.doubleValue();
    }

    /**
     * 除法(a / b)，并设置精度和舍入方式
     *
     * @param a
     * @param b
     * @param scale
     * @param roundingMode
     * @return
     */
    public static final Double divide(double a, double b, int scale, RoundingMode roundingMode) {
        return divide(String.valueOf(a), String.valueOf(b), scale, roundingMode);
    }

    /**
     * 使用默认配置(两位小数，四舍五入)设置数据精度
     *
     * @param a
     * @return
     */
    public static final Double setScale(double a) {
        return setScale(a, DEFAULT_SCALE);
    }

    /**
     * 设置数据精度
     *
     * @param a
     * @param scale
     * @return
     */
    public static final Double setScale(double a, int scale) {
        return setScale(a, scale, DEFAULT_ROUNDING_MODE);
    }

    /**
     * 设置数据精度
     *
     * @param a
     * @param scale        数据精度
     * @param roundingMode 舍入方式
     * @return
     */
    public static final Double setScale(double a, int scale, RoundingMode roundingMode) {
        return new BigDecimal(a)
                .setScale(scale, roundingMode)
                .doubleValue();
    }
}