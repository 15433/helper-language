package org.wlg.language.client;

import com.alibaba.fastjson.JSONObject;
import org.wlg.language.provider.LanguageResult;
import org.wlg.language.provider.TransApi;
import org.wlg.language.provider.TransLanguage;
import org.wlg.language.provider.TransLanguageImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11838
 */
public class MyClient {

    public static void main(String[] args) {

        TransLanguage transLanguage = new TransLanguageImpl();
        // 多个单词或者句子批量一起翻译时，用\n隔开
        String content = "公司\n" +
                "股份有限责任公司\n" +
                "设备模板编码\n" +
                "文本类型\n" +
                "企业通讯录-创建部门\n" +
                "本地编码\n" +
                "任务编码\n" +
                "斯威士兰 +268\n" +
                "权限范围编码\n" +
                "当前版本\n" +
                "个性化-未配置到单元的字段列表(组织层)\n" +
                "当前用户所属公司\n" +
                "创建\n" +
                "摩尔多瓦 +373\n" +
                "事件源名称\n" +
                "值\n" +
                "采购员编码\n" +
                "供应商地点\n" +
                "/hres/**\n" +
                "编码规则选择公司\n" +
                "模板名称\n" +
                "行分片规则\n" +
                "/hlod/**\n" +
                "行业编码\n" +
                "模型列\n" +
                "主机\n" +
                "互联网金融业\n" +
                "网关名称\n" +
                "物料\n" +
                "单据权限规则类型\n" +
                "清理六个月之前缺失权限记录\n" +
                "字段名称\n" +
                "邮政储蓄\n" +
                "个性化-条件关系\n" +
                "截止日期\n" +
                "霍尼亚拉\n" +
                "澳大利亚 +61\n" +
                "消息id\n" +
                "纯脚本模式\n" +
                "德国 +49\n" +
                "角色描述\n" +
                "/himp/**\n" +
                "POST\n" +
                "集体所有制企业\n" +
                "资源层级\n" +
                "查询\n" +
                "下上布局\n" +
                "希腊 +30\n" +
                "租户用户\n" +
                "hzero-workflow\n" +
                "后端标签\n" +
                "几内亚 +224\n" +
                "以色列 +972\n" +
                "账户名称\n" +
                "判异规则组\n" +
                "数字框\n" +
                "租户级\n" +
                "折叠面板\n" +
                "/hpfm/**\n" +
                "数据层级\n" +
                "执行命令线程池的核心线程数\n" +
                "地区查询\n" +
                "组织名称\n" +
                "清理一年之前缺失权限记录\n" +
                "角色代码\n" +
                "租户客户化\n" +
                "措施含义\n" +
                "Broadway\n" +
                "印度尼西亚 +62\n" +
                "密码模式\n" +
                "选择属于租户的角色\n" +
                "自定义Oracle数据库驱动主类入口\n" +
                "邮箱\n" +
                "依赖名称\n" +
                "清理三天之前缺失权限记录\n" +
                "hzero-swagger\n" +
                "数据集编码\n" +
                "值集视图字段类型\n" +
                "warn消息类型\n" +
                "分类描述\n" +
                "数据权限规则类型\n" +
                "分析人\n" +
                "所属网关\n" +
                "个性化-模型字段列表\n" +
                "选择客制化规则\n" +
                "通知类\n" +
                "选择值集\n" +
                "接口ID\n" +
                "选择库存组织\n" +
                "数据源配置(平台级)\n" +
                "联营企业\n" +
                "OAuth2 授权类型\n" +
                "法定假期\n" +
                "是否标识\n" +
                "子账户管理\n" +
                "瑞典 +46\n" +
                "选择父级角色\n" +
                "中国台湾地区 +886\n" +
                "查询单位类型\n" +
                "单据描述\n" +
                "一月一次\n" +
                "布基纳法索 +226\n" +
                "获取卡片信息(租户级)\n" +
                "通过服务名查询数据分发类型的数据源绑定的数据库 ,同时返回对应的数据源ID\n" +
                "隐藏\n" +
                "左固定\n" +
                "匈牙利 +36\n" +
                "公司类型\n" +
                "用户拥有的业务实体\n" +
                "钉钉\n" +
                "租户级选择租户\n" +
                "Hr基础数据同步外部系统同步类型\n" +
                "同步中\n" +
                "前置机编码\n" +
                "proxy规则主键策略\n" +
                "类别名称\n" +
                "数据类型\n" +
                "个性化-字段类型\n" +
                "C3p0数据源\n" +
                "选择流程定义KEY\n" +
                "上级岗位\n" +
                "系统编码\n" +
                "网关限流维度\n" +
                "升级包名称\n" +
                "企业行业\n" +
                "文莱 +673\n" +
                "简体中文\n" +
                "中国中央银行\n" +
                "乌拉圭 +598\n" +
                "结构名称\n" +
                "单据维度值来源类型\n" +
                "查询角色\n" +
                "成员类型\n" +
                "类别编号\n" +
                "事件类型描述\n" +
                "独立值集(租户级)\n" +
                "国家名称";

        // 每次调用接口翻译字数不超过4000，如果超过4000分次处理
        int index = TransApi.QUERY_MAX_LENGTH;
        if (content.length() > index) {
            index = content.lastIndexOf('\n', TransApi.QUERY_MAX_LENGTH);
        } else {
            index = content.length();
        }
        System.out.println(index);
        // 分治处理
        List<String> contents = TransLanguageImpl.getStrList(content, index);
        LanguageResult language = new LanguageResult();
        language.setFrom("zh");
        language.setTo("en");
        language.setTransResult(new ArrayList<>());
        for (String query : contents) {
            // 这里面这一段可以再封装一个方法 增加重试机制，比如最多重试三次
            // 例如：
            // int retry = 3;
            // 重试方法(query, from, to, language, retry);
            // 当result结果中包含52001/52002可以重试
            // 如果请求会返回54003，是因为百度翻译的普通版QPS（每秒请求量）=1 ，可以切换高级版（适用于个人，QPS=10）或尊享版（适用于企业，QPS=100）
            // 如果是本地使用，也可以让线程暂停500毫秒，再重试
            // 百度翻译文档 https://api.fanyi.baidu.com/doc/21
            System.out.println(query.trim().length());
            String result = transLanguage.transLanguage(query,"zh", "en");
            LanguageResult languageResult = JSONObject.parseObject(result, LanguageResult.class);
            System.out.println(JSONObject.toJSON(languageResult));
            language.getTransResult().addAll(languageResult.getTransResult());
        }
        System.out.println("language:" + JSONObject.toJSON(language));
    }
}
