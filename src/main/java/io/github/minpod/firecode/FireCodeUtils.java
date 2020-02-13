package io.github.minpod.firecode;

import io.github.minpod.firecode.code.FileUtil;
import io.github.minpod.firecode.code.PathUtil;
import io.github.minpod.firecode.code.VelocityUtil;
import io.github.minpod.firecode.database.Table;

import java.io.File;


/**
 * Created by mingle.
 * Time 2017/11/7 下午8:28
 * Desc 文件描述
 */
public class FireCodeUtils {
    
    public static String makeSql(Table table, String author, String module, String basePackage) {
        String path = PathUtil.getResourcesPath() + File.separator + "mybatis" + File.separator + "mapper" + File.separator + module + File.separator + table.getClazzName() + "Mapper" + ".xml";
        String code = VelocityUtil.make(author, basePackage, module, table, "sql.vm");
        FileUtil.writeToFile(path, code);
        return path;
    }
    
    // DOS
    public static String makeDO(Table table, String author, String module, String basePackage, String baseDir) {
        String dal = File.separator + "model" + File.separator + "dos" + File.separator;
        String doFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + dal + table.getClazzName() + "DO.java";
        String doCode = VelocityUtil.make(author, basePackage, module, table, "do.vm");
        FileUtil.writeToFile(doFile, doCode);
        return doFile;
    }

    // Mapper
    public static String makeMapper(Table table, String author, String module, String basePackage, String baseDir) {
        String mapper = File.separator + "mapper" + File.separator;
        String mapperFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + mapper + table.getClazzName() + "Mapper.java";
        String mapperCode = VelocityUtil.make(author, basePackage, module, table, "mapper.vm");
        FileUtil.writeToFile(mapperFile, mapperCode);
        return mapperFile;
    }

    // transUtils
    public static String makeTransUtils(Table table, String author, String module, String basePackage, String baseDir) {
        String trans = File.separator + "utils" + File.separator;
        String transFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + trans + table.getClazzName() + "TransUtils.java";
        String transCode = VelocityUtil.make(author, basePackage, module, table, "trans.vm");
        FileUtil.writeToFile(transFile, transCode);
        return transFile;
    }

    // DTO
    public static String makeDTO(Table table, String author, String module, String basePackage, String baseDir) {
        String dto = File.separator + "model" + File.separator + "dto" + File.separator;
        String dtoFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + dto + table.getClazzName() + "DTO.java";
        String dtoCode = VelocityUtil.make(author, basePackage, module, table, "dto.vm");
        FileUtil.writeToFile(dtoFile, dtoCode);
        return dtoFile;
    }

    // Request
    public static String makeReq(Table table, String author, String module, String basePackage, String baseDir) {
        String query = File.separator + "model" + File.separator + "req" + File.separator;
        String queryFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + query + table.getClazzName() + "Query.java";
        String queryCode = VelocityUtil.make(author, basePackage, module, table, "query.vm");
        FileUtil.writeToFile(queryFile, queryCode);
        return queryFile;
    }

    // Query
    public static String makeQuery(Table table, String author, String module, String basePackage, String baseDir) {
        // 1，初始化 OrderByColumnEnum
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "OrderByColumnEnum.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "order_by_column_enum.vm");
        FileUtil.writeIfExistToFile(file, code);

        // 2,生成baseQuery
        // com.youzan.mei.demo.model.BaseQuery
        file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "BaseQuery.java";
        code = VelocityUtil.make(author, basePackage, module, table, "base_query.vm");
        FileUtil.writeIfExistToFile(file, code);

        String query = File.separator + "model" + File.separator + "query" + File.separator;
        String queryFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + query + table.getClazzName() + "Query.java";
        String queryCode = VelocityUtil.make(author, basePackage, module, table, "query.vm");
        FileUtil.writeToFile(queryFile, queryCode);
        return queryFile;
    }

    // Param
    public static String makeParam(Table table, String author, String module, String basePackage, String baseDir) {
        String param = File.separator + "model" + File.separator + "param" + File.separator;
        String queryFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + param + table.getClazzName() + "Param.java";
        String queryCode = VelocityUtil.make(author, basePackage, module, table, "param.vm");
        FileUtil.writeToFile(queryFile, queryCode);
        return queryFile;
    }
    
    
    public static String makeCreate(Table table, String author, String module, String basePackage, String baseDir) {
        // 1，初始化 OrderByColumnEnum
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "OrderByColumnEnum.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "order_by_column_enum.vm");
        FileUtil.writeIfExistToFile(file, code);

        // 2，generate BaseParam
        // com.youzan.mei.demo.model.BaseParam
        file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "BaseParam.java";
        code = VelocityUtil.make(author, basePackage, module, table, "base_param.vm");
        FileUtil.writeIfExistToFile(file, code);

        // 3，生成对应的Param
        file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "param" + File.separator + "Create" + table.getClazzName() +
                "Param.java";
        code = VelocityUtil.make(author, basePackage, module, table, "param_create.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeUpdate(Table table, String author, String module, String basePackage, String baseDir) {
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "param" + File.separator + "Update" + table.getClazzName() +
                "Param.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "param_update.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeGet(Table table, String author, String module, String basePackage, String baseDir) {
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "query" + File.separator + table.getClazzName() +
                "GetQuery.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "query_get.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeSearch(Table table, String author, String module, String basePackage, String baseDir) {
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "query" + File.separator + table.getClazzName() + "SearchQuery.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "query_search.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeResp(Table table, String author, String module, String basePackage, String baseDir) {
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "dto" + File.separator + table.getClazzName() + "DTO.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "dto.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeManager(Table table, String author, String module, String basePackage, String baseDir) {
        // 1. plainResult
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "PlainResult.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "plain_result.vm");
        FileUtil.writeIfExistToFile(file, code);

        // 2. ListResult
        file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "ListResult.java";
        code = VelocityUtil.make(author, basePackage, module, table, "list_result.vm");
        FileUtil.writeIfExistToFile(file, code);

        String manager = File.separator + "manager" + File.separator;
        String managerFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + manager + table.getClazzName() + "Manager.java";
        String managerCode = VelocityUtil.make(author, basePackage, module, table, "manager.vm");
        FileUtil.writeToFile(managerFile, managerCode);
        return managerFile;
    }
    
    
    public static String makeManagerImpl(Table table, String author, String module, String basePackage, String baseDir) {
        // 1. plainResult
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "PlainResult.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "plain_result.vm");
        FileUtil.writeIfExistToFile(file, code);

        // 2. ListResult
        file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "ListResult.java";
        code = VelocityUtil.make(author, basePackage, module, table, "list_result.vm");
        FileUtil.writeIfExistToFile(file, code);

        String managerImpl = File.separator + "manager" + File.separator + "impl" + File.separator;
        String managerImplFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + managerImpl + table.getClazzName() + "ManagerImpl.java";
        String managerImplCode = VelocityUtil.make(author, basePackage, module, table, "manager_impl.vm");
        FileUtil.writeToFile(managerImplFile, managerImplCode);
        return managerImplFile;
    }
    
    
    public static String makeTest(Table table, String author, String module, String basePackage, String baseDir) {
        String testFile = PathUtil.getTestPath() + File.separator + baseDir + File.separator + module + File.separator + "mapper" + File.separator + table.getClazzName() + "MapperTest.java";
        String testCode = VelocityUtil.make(author, basePackage, module, table, "mapper_test.vm");
        FileUtil.writeToFile(testFile, testCode);
        return testFile;
    }
    
    
    public static String makeService(Table table, String author, String module, String basePackage, String baseDir) {
        // 1. plainResult
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "PlainResult.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "plain_result.vm");
        FileUtil.writeIfExistToFile(file, code);

        // 2. ListResult
        file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "ListResult.java";
        code = VelocityUtil.make(author, basePackage, module, table, "list_result.vm");
        FileUtil.writeIfExistToFile(file, code);


        String service = File.separator + "service" + File.separator;
        String serviceFile = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + service + table.getClazzName() + "Service.java";
        String serviceCode = VelocityUtil.make(author, basePackage, module, table, "service.vm");
        FileUtil.writeToFile(serviceFile, serviceCode);
        return serviceFile;
    }
    
    
    public static String makeServiceTest(Table table, String author, String module, String basePackage, String baseDir) {
        String file = PathUtil.getTestPath() + File.separator + baseDir + File.separator + module + File.separator + "service" + File.separator + table.getClazzName() + "ServiceTest.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "service_test.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
    
    
    public static String makeServiceImpl(Table table, String author, String module, String basePackage, String baseDir) {
        // 1. plainResult
        String file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "PlainResult.java";
        String code = VelocityUtil.make(author, basePackage, module, table, "plain_result.vm");
        FileUtil.writeIfExistToFile(file, code);

        // 2. ListResult
        file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "ListResult.java";
        code = VelocityUtil.make(author, basePackage, module, table, "list_result.vm");
        FileUtil.writeIfExistToFile(file, code);

        // 3. ResultUtils
        file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + File.separator + "model" + File.separator + "ResultUtils.java";
        code = VelocityUtil.make(author, basePackage, module, table, "result_utils.vm");
        FileUtil.writeIfExistToFile(file, code);

        String path = File.separator + "service" + File.separator + "impl" + File.separator;
        file = PathUtil.getJavaPath() + File.separator + baseDir + File.separator + module + path + table.getClazzName() + "ServiceImpl.java";
        code = VelocityUtil.make(author, basePackage, module, table, "service_impl.vm");
        FileUtil.writeToFile(file, code);
        return file;
    }
}
