package acme.features.administrator.systemSetting;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;
import acme.systemSetting.SystemSetting;

@Repository
public interface AdministratorSystemSettingRepository extends AbstractRepository {
	@Query("select st from SystemSetting st")
	SystemSetting findOneSytemSetting();
}
