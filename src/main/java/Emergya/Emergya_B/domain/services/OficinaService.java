package Emergya.Emergya_B.domain.services;

import Emergya.Emergya_B.domain.models.Oficina;
import Emergya.Emergya_B.infrarepositorie.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OficinaService {

    private static OficinaRepository oficinaRepository;

    @Autowired

    public OficinaService(OficinaRepository oficinaRepository) {
        OficinaService.oficinaRepository = oficinaRepository;
    }



    public static final List<Oficina> getOficina(){

        return oficinaRepository.findAll();
    }
    public static final void newOficina(Oficina oficina) {
        oficinaRepository.save(oficina);
    }

    public void update(Integer id, Oficina oficina) {
        Optional<Oficina> oficinaById = oficinaRepository.findById(id);

        if(oficinaById.isPresent()){
            Oficina oficinaExistente = oficinaById.get();

            oficinaExistente.setNombreoficina(oficina.getNombreoficina());
            oficinaExistente.setPlanodistribucion(oficina.getPlanodistribucion());
            oficinaExistente.setPuesto(oficina.getPuesto());
            oficinaExistente.setDiasantelacion(oficina.getDiasantelacion());

            oficinaRepository.save(oficinaExistente);
        }

    }
}