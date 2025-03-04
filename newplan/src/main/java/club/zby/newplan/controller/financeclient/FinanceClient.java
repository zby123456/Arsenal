package club.zby.newplan.controller.financeclient;

import club.zby.newplan.Entity.Finance;
import club.zby.newplan.Interceptor.FeignInterceptor;
import club.zby.newplan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@FeignClient(name = "finance",fallback = FinanceClientImp.class,configuration = {FeignInterceptor.class})//uereka中的注册服务名，
public interface FinanceClient {

    @GetMapping(value = "Finance/showfinance")
    Result findAllByWho();

    @PostMapping(value = "Finance/savefinance")//原方法执行路径
    Result saveFinance(@RequestBody Finance finance);

    @DeleteMapping(value = "Finance/delfinance/{id}")
    Result delFinance(@PathVariable("id") String id);

    @GetMapping(value = "Finance/financeview")
    Result financeView();
}