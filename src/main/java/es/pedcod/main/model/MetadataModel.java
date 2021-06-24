package es.pedcod.main.model;

import java.io.Serializable;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * Meta-information to principal model
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MetadataModel implements Serializable {

	/**
	 * @see java.io.Serializable
	 */
	static final long serialVersionUID = 1L;

	/** The identifier auto generated */
	@Schema(
			description = "The identifier auto generated",  
			example = "00000000-0000-0000-0000-000000000001")
	UUID principal;

	/**
	 * Date/Time it was saved the first time
	 */
	@Schema(
			description = "Date/Time it was saved the first time",  
			example = "671767186162378172837182378193L")
	Long created;

}
