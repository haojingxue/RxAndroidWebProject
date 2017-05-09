package com.mm.cme.rx_android_web_project.bean;

import com.mm.cme.rx_android_web_project.constants.StateE;

/**
 * Descriptions：状态的Bean
 * <p>
 * Author：ChenME
 * Date：10/28/2016
 * Email：ibelieve1210@163.com
 */
public class StateBean {

    private String stateCode;
    private String stateMessage;

    public StateBean(){}

    public StateBean(StateE state, String msg) {
        setCodeByEnum(state);
        this.stateMessage = msg;
    }

    private void setCodeByEnum(StateE state) {
        switch (state) {
            case SUCCESS:
                stateCode = "0000";//成功
                break;
            case ERROR:
                stateCode = "0001";//失败
                break;
        }
    }

    public void setStateCode(StateE state) {
        setCodeByEnum(state);
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    @Override
    public String toString() {
        return "StateBean{" +
                "stateCode='" + stateCode + '\'' +
                ", stateMessage='" + stateMessage + '\'' +
                '}';
    }
}