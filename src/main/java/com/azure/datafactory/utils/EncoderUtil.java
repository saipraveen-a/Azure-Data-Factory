package com.azure.datafactory.utils;

import com.google.common.base.Preconditions;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

public final class EncoderUtil {

  private EncoderUtil() {}

  public static String getBase64EncodedString(String input) throws UnsupportedEncodingException {
    Preconditions.checkArgument(StringUtils.isNotBlank(input));
    return new String(new Base64().encode(input.getBytes("UTF-8")), "UTF-8");
  }

  public static String getBase64DecodedString(String input) throws UnsupportedEncodingException {
    Preconditions.checkArgument(StringUtils.isNotBlank(input));
    return new String(Base64.decodeBase64(input.getBytes("UTF-8")), "UTF-8");
  }
}
