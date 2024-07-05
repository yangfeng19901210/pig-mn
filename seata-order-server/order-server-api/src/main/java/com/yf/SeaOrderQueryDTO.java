package com.yf;

import lombok.Data;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: SeaOrderQueryDTO
 ** @author: yangfeng
 ** @date: 2024/7/4 10:36
 ** @version: 1.0.0
 *********************************************************/
@Data
public class SeaOrderQueryDTO {
    /**
     * 查询时间范围
     */
    private String[] queryTimeRound;

    private String type;
}
