package com.th.demo.common;

/**
 * 模块中的常量
 * @author sijianmeng
 */
public class Constant {
    //分隔符
    public static final String SEPARATOR = ",";

    //时间格式
    public static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";


    //请求参数
    public static final String CODE = "code";
    public static final String MSG = "msg";
    public static final String RESULT = "result";
    public static final String DATA = "data";

    public static final String OK = "OK";
    public static final String ERROR = "ERROR";

    public static final String OK_MSG = "操作成功";
    public static final String ERROR_MGS = "操作失败";
    public static final String EXPORT_ERROR = "导出失败";
    public static final String ADD_ERROR = "新增失败";
    public static final String UPDATE_ERROR = "修改失败";
    public static final String DEL_ERROR = "删除失败";
    public static final String EXPORT_OK = "导出成功";
    public static final String ADD_OK = "新增成功";
    public static final String UPDATE_OK = "修改成功";
    public static final String DEL_OK = "删除成功";
    public static final String FLAG_ERROR= "页面标识错误";
    public static final String START_OK= "启动成功";
    public static final String STOP_OK= "停止成功";
    public static final String START_ERROR= "启动失败";

    /**
     * 标识
     */
    //供应商
    public static final String PROVIDER_PRE = "P";
    public static final String PROVIDER_SUF = "00001";
    //一级标识
    public static final String CATE_FIRST_PRE = "F";
    public static final String CATE_FIRST_SUF = "00001";
    //二级标识
    public static final String CATE_SECOND_PRE = "S";
    public static final String CATE_SECOND_SUF = "00001";
    //对象
    public static final String ACO_PRE = "AC";
    public static final String ACO_SUF = "00001";
    //对象
    public static final String SET_PRE = "D";
    public static final String SET_SUF = "00001";
    //对象
    public static final String TASK_PRE = "_TASK";
    public static final String TASK_SUF = "1";

    public static final String URI_PRE = "daas://";

    /**
     * 模块
     */
    //Provider
    public static final String PRO_FILE_NAME = "供应商";
    public static final String PRO_COL_NAMES = "供应商名称,供应商标识,创建时间,供应商描述";
    public static final String PRO_COL_KEYS = "proTitle,proCode,proCTime,proDesc";

    //Category
    public static final String CAT_FILE_NAME = "一级分类";
    public static final String CAT_COL_NAMES = "一级分类名称,一级分类标识,创建人,二级分类数,一级分类描述";
    public static final String CAT_COL_KEYS = "cateTitle,cateCode,cateCreater,cateCount,cateDesc";

    //Objects
    public static final String OBJ_FILE_NAME = "接入对象";
    public static final String OBJ_FTP_COL_NAMES = "对象名称,对象标识,供应商名称,FTP地址,FTP端口,用户名,根目录";
    public static final String OBJ_API_COL_NAMES = "对象名称,对象标识,供应商名称,链接地址,获取规则";
    public static final String OBJ_FTP_COL_KEYS = "acoTitle,acoCode,proTitle,ip,port,user,rootPath";
    public static final String OBJ_API_COL_KEYS = "acoTitle,acoCode,proTitle,url,kafkaTopic";

    //warnning
    public static final String WARN_OVER_TIME_COUNTS = "overtimeCounts";
    public static final String WARN_ATYPICAL_COUNTS = "atypicalCounts";
    public static final String WARN_OUTSIDE_COUNTS = "outsideCounts";
    public static final String WARN_REPEAT_FILES_COUNTS = "repeatFilesCounts";

    //qclog
    public static final String QC_LOG_FILE_NAME = "质检入库日志";
    public static final String QC_LOG_COL_NAMES = "文件名称,所属数据集,分类名称,执行人,记录时间,日志内容";
    public static final String QC_LOG_COL_KEYS = "fileName,taskName,cateTitle,executor,createTime,message";

    //warnning导出cvs
    public static final String WARNNING_FILE_NAME = "告警";
    public static final String WARNNING_COL_NAMES = "数据集名称,告警类型,数据源类型,目标介质类型,任务类型,告警时间";
    public static final String WARNNING_COL_KEYS = "taskName,warnningType,dsType,medium,taskType,createTime";
//    public static final String WARNNING_COL_NAMES = "任务标识,数据集名称,告警类型,接入类型,更新周期,传输标准,更新定时时间,告警时间";
//    public static final String WARNNING_COL_KEYS = "taskId,taskName,warnningType,acoType,upCycle,tranStandard,upHour,createTime";

    //dataset
    public static final String DATASET_AUTO_PASS_SUCCESS = "自动过检成功";

    public static final String API_RESPONSE_PARAMS_CODE = "code";
    public static final String API_RESPONSE_PARAMS_MSG = "message";
    public static final String API_RESPONSE_PARAMS_RESULT = "result";
    public static final String API_RESPONSE_PARAMS_DATAS = "datas";
    public static final String API_RESPONSE_PARAMS_DATA = "data";
    public static final String API_RESPONSE_PARAMS_TOTALCOUNTS = "totalCounts";

    public static final Integer API_RESULT_CODE_SUCCESS = 200;
    public static final String API_RESULT_CODE_MSG_SUCCESS = "操作成功";


    //外部接口
    public static final String OUTER_FTP_TASK = "http://192.168.11.52:18010/api/v1/daas/access/core/tasks/";
    public static final String OUTER_API_TASK_ADD = "http://192.168.11.53:7788/api/v1/daas/apiaccess/core/task";
    public static final String OUTER_API_TASK_DEL = "http://192.168.11.53:7789/api/v1/daas/apiaccess/core/task/";
    public static final String OUTER_API_TASK_OP = "http://192.168.11.53:7787/api/v1/daas/apiaccess/core/task/";
    public static final String OUTER_API_TASK_UPDATE = "http://192.168.11.53:7786/api/v1/daas/apiaccess/core/edittask";


    // FTP 文件操作
    public static final String JSCH_DIRECTORY_SIGN = "d";
    public static final String JSCH_CSV_SIGN = ".csv";
    public static final String JSCH_TXT_SIGN = ".txt";
    public static final String JSCH_JSON_SIGN = ".json";
    public static final String JSCH_JSONS_SIGN = ".jsons";

    // SSO USER
    public static final String SSO_ACCESSTOKEN = "accessToken";
    public static final String SSO_ACCOUNTNAME = "accountName";
    public static final String SSO_ACCOUNTID = "accountId";
    public static final String SSO_ACCOUNTTENANTID = "tenantId";
    public static final String REQUEST_METHOD_OPTIONS = "OPTIONS";

}
