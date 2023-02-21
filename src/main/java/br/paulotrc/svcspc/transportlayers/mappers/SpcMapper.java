package br.paulotrc.svcspc.transportlayers.mappers;

import br.paulotrc.svcspc.entites.Spc;
import br.paulotrc.svcspc.transportlayers.dto.request.SpcRequest;
import br.paulotrc.svcspc.transportlayers.dto.response.SpcResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface SpcMapper {

    SpcMapper INSTANCE = Mappers.getMapper(SpcMapper.class);

    Spc map(SpcRequest spcRequest);

    SpcResponse mapResponse(Spc spc);

    default List<SpcResponse> mapListResponse(List<Spc> spcs){
        final List<SpcResponse> spcResponseList = new ArrayList<>();
        for (Spc spc:spcs) {
            SpcResponse spcResp = SpcMapper.INSTANCE.mapResponse(spc);
            spcResponseList.add(spcResp);
        }
        return spcResponseList;
    }
}

