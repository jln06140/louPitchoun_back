//package co.simplon.converter;
//
//public class CustomConverter implements AttributeConverter<Status, String> {
//
//    @Override
//    public String convertToDatabaseColumn(Status attribute) {
//        return attribute.getValue() ;
//    }
//
//    @Override
//    public Status convertToEntityAttribute(String dbData) {
//        return  StatusFirmaDocumento.fromString(dbData);
//    }
//
//}