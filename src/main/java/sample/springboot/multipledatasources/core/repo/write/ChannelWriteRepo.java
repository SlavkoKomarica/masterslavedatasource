package sample.springboot.multipledatasources.core.repo.write;

import org.springframework.data.repository.CrudRepository;
import sample.springboot.multipledatasources.core.model.Channel;

/**
 * @author Slavko Komarica
 */
public interface ChannelWriteRepo extends CrudRepository<Channel, Long> {
}
