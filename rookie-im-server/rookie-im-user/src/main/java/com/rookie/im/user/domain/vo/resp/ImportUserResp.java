package com.rookie.im.user.domain.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.util.List;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/22 21:20
 * @Version: 1.0
 */
@Data
@Tag(name = "批量导入用户返回实体")
public class ImportUserResp {

    @Schema(description = "错误导入用户名称列表")
    List<String>  errorImportUserName;

}
