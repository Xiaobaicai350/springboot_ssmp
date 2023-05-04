package com.haohao.utils;

import lombok.Data;

@Data
public class R {
    //用于标识操作是否成功
    private Boolean flag;
    //data用于封装操作数据
    private Object data;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
