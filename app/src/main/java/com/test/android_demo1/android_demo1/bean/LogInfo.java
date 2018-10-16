package com.test.android_demo1.android_demo1.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/16.
 */

public class LogInfo {

    /**
     * data : {"data":[{"id":253,"name":"11111111","e_mail":"111@111.com","create_date":"2018-10-16T08:27:22.000Z","id_no":"111111111111111","phone":"18111111111","reset_password":"","sex":"","password_md5":"90c4edebb97499a10316c9aa582f5499"}]}
     * stateText : 登陆成功
     * stateCode : 1
     * success : false
     */

    private DataBeanX data;
    private String stateText;
    private int stateCode;
    private boolean success;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getStateText() {
        return stateText;
    }

    public void setStateText(String stateText) {
        this.stateText = stateText;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBeanX {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 253
             * name : 11111111
             * e_mail : 111@111.com
             * create_date : 2018-10-16T08:27:22.000Z
             * id_no : 111111111111111
             * phone : 18111111111
             * reset_password :
             * sex :
             * password_md5 : 90c4edebb97499a10316c9aa582f5499
             */

            private int id;
            private String name;
            private String e_mail;
            private String create_date;
            private String id_no;
            private String phone;
            private String reset_password;
            private String sex;
            private String password_md5;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getE_mail() {
                return e_mail;
            }

            public void setE_mail(String e_mail) {
                this.e_mail = e_mail;
            }

            public String getCreate_date() {
                return create_date;
            }

            public void setCreate_date(String create_date) {
                this.create_date = create_date;
            }

            public String getId_no() {
                return id_no;
            }

            public void setId_no(String id_no) {
                this.id_no = id_no;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getReset_password() {
                return reset_password;
            }

            public void setReset_password(String reset_password) {
                this.reset_password = reset_password;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getPassword_md5() {
                return password_md5;
            }

            public void setPassword_md5(String password_md5) {
                this.password_md5 = password_md5;
            }
        }
    }
}
