package es.pedcod.main.api;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.pedcod.main.model.MetadataModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller for METADATA element on system. Only <b>non-transactional</b>
 * execution.
 */
@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
@RequestMapping(value = "/api/metadata", produces = { MediaType.APPLICATION_JSON_VALUE })
@Api(tags = { "Metadata" })
@Slf4j
public class ReadAllRestController {

	/**
	 * Retrieve all elements type {@link MetadataModel} in system.
	 * 
	 * @return All elements available.
	 */
	@ApiOperation(value = "Retrieve all metadata available type in the system.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "The metadata are retrieved successfully") })
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<MetadataModel> readAll() {
		log.debug("Try to get all elements type by metadata in the system");
		return Stream
				.of(MetadataModel.builder()
						.principal(UUID.randomUUID())
						.created(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli())
						.build(),
					MetadataModel.builder()
						.principal(UUID.randomUUID())
						.created(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli())
						.build())
				.peek(metaData -> log.debug("Available metadata: {}", metaData.toString()))
				.collect(Collectors.toList());
	}

}
