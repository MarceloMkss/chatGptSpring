package com.formacion.sepe.chatgptspring.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

        public String getPrompt(String album) {

            return "si" + album + "no es un disco de algun grupo o artista musical responde: no conozco esa obra"
                    + "en caso contrario haz una descripcion muy breve  y concisa del disco titulado"
                    + album + " y añade la frase: 'Te gustara si te gustan' "
                    + "y a continuacion cita tres artistas similares";

        }
}
