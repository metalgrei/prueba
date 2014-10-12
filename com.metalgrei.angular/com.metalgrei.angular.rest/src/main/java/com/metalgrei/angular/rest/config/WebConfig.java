package com.metalgrei.angular.rest.config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.metalgrei.angular.core.constant.EncodingUtil;

/**
 * The Class WebConfig.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.metalgrei.angular.rest"})
public class WebConfig extends WebMvcConfigurerAdapter {
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureMessageConverters(java.util.List)
	 */
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {

		MappingJacksonHttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJacksonHttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();

		supportedMediaTypes.add(new MediaType("application", "json", Charset
				.forName(EncodingUtil.UTF_8)));
		mappingJacksonHttpMessageConverter
				.setObjectMapper(new CustomObjectMapper());
		mappingJacksonHttpMessageConverter
				.setSupportedMediaTypes(supportedMediaTypes);
		converters.add(mappingJacksonHttpMessageConverter);
	}
	
	/**
	 * The Class CustomObjectMapper.
	 */
	public static class CustomObjectMapper extends ObjectMapper {

		/**
		 * Instantiates a new custom object mapper.
		 */
		public CustomObjectMapper() {
			super();
			configure(Feature.WRITE_DATES_AS_TIMESTAMPS, false);
			configure(Feature.WRITE_NULL_MAP_VALUES, false);
			setSerializationInclusion(Inclusion.NON_NULL);
			getSerializerProvider().setNullKeySerializer(
					new NullKeySerializer());
			setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
		}

		/**
		 * The Class NullKeySerializer.
		 */
		private class NullKeySerializer extends JsonSerializer<Object> {
			
			/* (non-Javadoc)
			 * @see org.codehaus.jackson.map.JsonSerializer#serialize(java.lang.Object, org.codehaus.jackson.JsonGenerator, org.codehaus.jackson.map.SerializerProvider)
			 */
			@Override
			public void serialize(final Object nullKey, final JsonGenerator jsonGenerator,
					final SerializerProvider unused) throws IOException,
					JsonProcessingException {
				jsonGenerator.writeFieldName("");
			}
		}
	}

}
