package egen.Service;

import egen.Entity.Tire;
import egen.Repository.TireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chath on 7/7/2017.
 */
@Service
public class TireServiceImpl implements TireService{

    @Autowired
    TireRepo tr;

    @Transactional
    public Tire create(Tire tire){
        return tr.create(tire);

    }
}
