package info.moraes.pedidoservice.repository;


import info.moraes.pedidoservice.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
