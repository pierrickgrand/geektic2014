import com.ninja_squad.geektic.Dao.GeekDao;
import com.ninja_squad.geektic.model.Geek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/Interets")
public class InteretService {


    @Autowired
    private GeekDao lesGeeks;

    @RequestMapping(method = RequestMethod.GET, params = "interet")
    public List<Geek> getGeeksByInteret(@RequestParam("interet") String interet) {
        List<Geek> MesGeeks = lesGeeks.getGeeksByInteret("FEMME");
        return MesGeeks;
    }



}