package com.xudt.shop.controller;

import com.xudt.shop.model.ResultBO;
import com.xudt.shop.service.ImgUploadService;
import com.xudt.shop.utils.enums.ImgErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 图片上传
 */
@Controller
@RequestMapping("/upload")
public class ImgUploadController {

    @Autowired
    private ImgUploadService fileUpAndDownService;

    /**
     * 上传图片
     * @param file
     * @return ResultBO
     */
    @RequestMapping(value = "/setFileUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResultBO setFileUpload(@RequestParam(value = "file", required = false) MultipartFile file) {
        ResultBO result = new ResultBO();
        try {
            //上传图片
            Map<String, Object> resultMap = upload(file);
            if (!ImgErrorEnum.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                result.setCode(ImgErrorEnum.ERROR.getCode());
                result.setMsg((String) resultMap.get("msg"));
                return result;
            }
            result.setCode(ImgErrorEnum.SUCCESS.getCode());
            result.setMsg(ImgErrorEnum.SUCCESS.getMessage());
            result.setData(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(ImgErrorEnum.ERROR.getCode());
            result.setMsg(ImgErrorEnum.FILE_UPLOAD_ERROR.getMessage());
        }
        return result;
    }

    /**
     * 图片上传
     * @param file
     * @return Map<String, Object>
     */
    private Map<String, Object> upload(MultipartFile file) {
        try {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            if (!file.isEmpty()) {
                Map<String, Object> picMap = fileUpAndDownService.uploadPicture(file);
                if (ImgErrorEnum.SUCCESS.getMessage().equals(picMap.get("result"))) {
                    return picMap;
                }
                returnMap.put("result", ImgErrorEnum.ERROR.getMessage());
                returnMap.put("msg", picMap.get("result"));
                return returnMap;
            }
            returnMap.put("result", ImgErrorEnum.ERROR.getMessage());
            returnMap.put("msg", ImgErrorEnum.FILE_UPLOAD_NULL);
            return returnMap;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }
}
