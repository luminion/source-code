/**
 *
 * jackson2对象映射器生成器定制器配置
 * <p>
 * servlet中jackson的配置{@link org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration}
 * 实际在配置源码在同包下的JacksonHttpMessageConvertersConfiguration(非public类)
 * 其使用Import导入了配置
 * <p>
 * webflux中jackson的配置{@link org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration }
 * 在WebFluxAutoConfiguration中导入了CodecsAutoConfiguration
 *
 * @see org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration
 * @see org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration
 * @see org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration#standardJacksonObjectMapperBuilderCustomizer
 *
 * @author bootystar
 * 
 */
public class Source4SpringJacksonAutoConfig {
    //    @Configuration(proxyBeanMethods = false)
//    @ConditionalOnClass(Jackson2ObjectMapperBuilder.class)
//    @AutoConfigureBefore(org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration.class)
//    static class JacksonObjectMapperBuilderConfiguration {
//
//        @Bean
//        @Scope("prototype")
//        @ConditionalOnMissingBean
//        Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder(ApplicationContext applicationContext, List<Jackson2ObjectMapperBuilderCustomizer> customizers) {
//            Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//            builder.applicationContext(applicationContext);
//            Jackson2ObjectMapperBuilderCustomizer customizer = new Jackson2ObjectMapperBuilderCustomizerConfiguration().jackson2ObjectMapperBuilderCustomizer();
//            customizer.customize(builder);
//            customize(builder, customizers);
//            log.debug("Jackson2ObjectMapperBuilder Configured");
//            return builder;
//        }
//
//        private void customize(Jackson2ObjectMapperBuilder builder, List<Jackson2ObjectMapperBuilderCustomizer> customizers) {
//            for (Jackson2ObjectMapperBuilderCustomizer customizer : customizers) {
//				customizer.customize(builder);
//			}
//		}
//	}

    /* =====servlet中jackson的配置源码=====
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(ObjectMapper.class)
    @ConditionalOnBean(ObjectMapper.class)
//    @ConditionalOnProperty(name = HttpMessageConvertersAutoConfiguration.PREFERRED_MAPPER_PROPERTY,
            havingValue = "jackson", matchIfMissing = true)
    static class MappingJackson2HttpMessageConverterConfiguration {

        @Bean
        @ConditionalOnMissingBean(value = MappingJackson2HttpMessageConverter.class,
                ignoredType = {
                        "org.springframework.hateoas.server.mvc.TypeConstrainedMappingJackson2HttpMessageConverter",
                        "org.springframework.data.rest.webmvc.alps.AlpsJsonHttpMessageConverter" })
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(ObjectMapper objectMapper) {
            return new MappingJackson2HttpMessageConverter(objectMapper);
        }

    }

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(XmlMapper.class)
    @ConditionalOnBean(Jackson2ObjectMapperBuilder.class)
    protected static class MappingJackson2XmlHttpMessageConverterConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter(
                Jackson2ObjectMapperBuilder builder) {
            return new MappingJackson2XmlHttpMessageConverter(builder.createXmlMapper(true).build());
        }

    }

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(XmlMapper.class)
    @ConditionalOnBean(Jackson2ObjectMapperBuilder.class)
    protected static class MappingJackson2XmlHttpMessageConverterConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter(
                Jackson2ObjectMapperBuilder builder) {
            return new MappingJackson2XmlHttpMessageConverter(builder.createXmlMapper(true).build());
        }

    }
    =====servlet中jackson的配置源码===== */

    /* =====webflux中jackson的配置源码=====
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(ObjectMapper.class)
    static class JacksonCodecConfiguration {

        @Bean
        @Order(0)
        @ConditionalOnBean(ObjectMapper.class)
        CodecCustomizer jacksonCodecCustomizer(ObjectMapper objectMapper) {
            return (configurer) -> {
                CodecConfigurer.DefaultCodecs defaults = configurer.defaultCodecs();
                defaults.jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper, EMPTY_MIME_TYPES));
                defaults.jackson2JsonEncoder(new Jackson2JsonEncoder(objectMapper, EMPTY_MIME_TYPES));
            };
        }

    }

    @Configuration(proxyBeanMethods = false)
    static class DefaultCodecsConfiguration {

        @Bean
        @Order(0)
        CodecCustomizer defaultCodecCustomizer(CodecProperties codecProperties) {
            return (configurer) -> {
                PropertyMapper map = PropertyMapper.get();
                CodecConfigurer.DefaultCodecs defaultCodecs = configurer.defaultCodecs();
                defaultCodecs.enableLoggingRequestDetails(codecProperties.isLogRequestDetails());
                map.from(codecProperties.getMaxInMemorySize())
                        .whenNonNull()
                        .asInt(DataSize::toBytes)
                        .to(defaultCodecs::maxInMemorySize);
            };
        }

    }
    =====webflux中jackson的配置源码===== */
}
