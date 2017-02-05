package sample.springboot.multipledatasources.core.repo.read;

import org.springframework.data.repository.CrudRepository;
import sample.springboot.multipledatasources.core.model.Channel;

import java.util.List;

/**
 * @author Slavko Komarica
 */
public interface ChannelReadRepo extends CrudRepository<Channel, Long> {
    List<Channel> findAll();
}
