package tour_agency.repositories.Impl;

import org.springframework.stereotype.Repository;
import tour_agency.entities.ClientEntity;
import tour_agency.repositories.BaseRepository;
import tour_agency.repositories.ClientRepository;
@Repository
public class ClientRepositoryImpl extends BaseRepository<ClientEntity, Long> implements ClientRepository {
    @Override
    public ClientEntity findById(Long id) {
        return super.findById(ClientEntity.class, id);
    }
}
