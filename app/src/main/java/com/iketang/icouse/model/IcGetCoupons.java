package com.iketang.icouse.model;

import java.util.List;

/**
 * 项目名称 icouse
 * <p/>
 * Created by hexiaomin on 2016/4/7.
 */
public class IcGetCoupons {


    /**
     * code : success
     * desc : 查询成功
     * data : [{"status":"0","startTime":"1459785600","codeSn":"2016040711112672105","factor":"10","total":"100","endTime":"1459872000"},{"status":"0","startTime":"1459872000","codeSn":"2016040710354296304","factor":"50","total":"500","endTime":"1459958400"},{"status":"0","startTime":"1459872000","codeSn":"2016040710332548650","factor":"50","total":"500","endTime":"1459958400"},{"status":2,"startTime":"1459872000","codeSn":"2016040617004450125","factor":"10","total":"100","endTime":"1460563200"},{"status":"0","startTime":"1459872000","codeSn":"2016040617003524540","factor":"50","total":"500","endTime":"1459958400"}]
     */

    private String code;
    private String desc;
    private List<DataEntity> data;

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * status : 0
         * startTime : 1459785600
         * codeSn : 2016040711112672105
         * factor : 10
         * total : 100
         * endTime : 1459872000
         */

        private String status;
        private String startTime;
        private String codeSn;
        private String factor;
        private String total;
        private String endTime;

        public void setStatus(String status) {
            this.status = status;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public void setCodeSn(String codeSn) {
            this.codeSn = codeSn;
        }

        public void setFactor(String factor) {
            this.factor = factor;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getStatus() {
            return status;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getCodeSn() {
            return codeSn;
        }

        public String getFactor() {
            return factor;
        }

        public String getTotal() {
            return total;
        }

        public String getEndTime() {
            return endTime;
        }
    }
}
