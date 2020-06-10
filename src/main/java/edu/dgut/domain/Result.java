package edu.dgut.domain;

public class Result<T> {
    private int code;
    private String msg;
    private int count;
    private T data;


    public Result() {
        super();
    }

    public Result(int code, int count,String msg, T data) {
        this.code = code;
        this.count = count;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功的调用以及返回
     * @return
     */
    public static  <T> Result<T> success(T data,int count){
        return new Result<T>(data,count);
    }
    public static  <T> Result<T> success0(){
        return new Result<T>();
    }
    private Result(T data,int count){
        this.code=0;//默认000000是成功
        this.msg="success";
        this.data = data;
        this.count = count;
    }


    /**
     * 失败的调用和返回
     * @return
     */
    public static  <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }
    private Result(CodeMsg codeMsg) {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }





    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }




    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    //调用方法
    // return Result.success(user);
    //return Result.error(CodeMsg.MOBILE_ERROR);
}
