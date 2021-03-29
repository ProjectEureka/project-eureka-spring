package com.ProjectEureka.backend.services.agora.media;

public interface PackableEx extends Packable {
    void unmarshal(ByteBuf in);
}
