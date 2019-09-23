package club.zby.finance.Dao;

import club.zby.finance.Entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FinanceDao extends JpaRepository<Finance,String>, JpaSpecificationExecutor<Finance> {

    List<Finance> findAllByWho(String who);

}
