package co.simplon.dao;

import co.simplon.enums.SectionEnum;
import co.simplon.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionDao extends JpaRepository<Section, Long> {
     Section findByNom(SectionEnum sectionEnum);

}
