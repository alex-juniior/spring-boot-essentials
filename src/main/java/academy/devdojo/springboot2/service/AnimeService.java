package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class AnimeService {
    private List<Anime> animes = List.of(new Anime(1L, "KKJ"), new Anime(2L, "Breserk"));
    //private final AnimeRepository animeRepository
    public List<Anime> listAll(){
        return animes;
    }
    public Anime findById(long id){
        return animes.stream()
                .filter(animes -> animes.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));

    }
}
