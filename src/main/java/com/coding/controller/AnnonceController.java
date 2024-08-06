package com.coding.controller;

import com.coding.entity.annonce;
import com.coding.service.AnnonceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/annonce")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @GetMapping("/list")
    public ResponseEntity<List<annonce>> getAllAnnonces() {
        List<annonce> annonces;
        try {
            annonces = annonceService.getAllAnnone();
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().body(annonces);
    }

    @GetMapping("/{id}")
    public ResponseEntity<annonce> getAnnonce(@PathVariable Long id) {
        annonce annonce;
        try {
            annonce = annonceService.getAnnonceById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().body(annonce);
    }

    @PostMapping("/add")
    public ResponseEntity<annonce> createAnnonce(@RequestParam("image") MultipartFile file,
                                                 @RequestParam("titre") String titre,
                                                 @RequestParam("description") String description,
                                                 @RequestParam("dateEvent") String dateEvent) throws JsonProcessingException {
        annonce annonce = new annonce();
        annonce.setTitre(titre);
        annonce.setDescription(description);
        annonce.setDateEvent(Date.valueOf(dateEvent));

        String repertoireImage = "src/main/resources/images"; // Remplacez par le chemin souhaité pour le répertoire "images"
        File repertoire = new File(repertoireImage);
        if (!repertoire.exists()) {// si le dossier images nexiste pas on va le creer
            boolean repertoireCree = repertoire.mkdirs();
            if (!repertoireCree) {
                throw new RuntimeException("Impossible de créer le répertoire 'images'");
            }
        }
        String nomFichier = file.getOriginalFilename();
        String nouveauNom = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(nomFichier);
        File fichierDuServeur = new File(repertoire, nouveauNom);
        try {
            FileUtils.writeByteArrayToFile(fichierDuServeur, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        annonce.setImage(nouveauNom);
        return ResponseEntity.ok().body(annonceService.creatAnnonce(annonce));
    }

    
    // recuperstion dune image a partir de id annonce
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        annonce annonce = annonceService.getAnnonceById(id);//findById(id);
        String repertoireImage = "src/main/resources/images";
        String cheminFichierImage = repertoireImage + "/" + annonce.getImage();

        try {
            Path cheminVersImages = Paths.get(cheminFichierImage);
            byte[] imageBytes = Files.readAllBytes(cheminVersImages);
            String contentType = Files.probeContentType(cheminVersImages);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(contentType));
            headers.setContentLength(imageBytes.length);
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<annonce> deleteAnnonce(@PathVariable("id") Long id) {
        annonce annonce;
        try {
            annonce = annonceService.deletAnnonce(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().body(annonce);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<annonce> updateAnnonce(@PathVariable("id") Long id, @RequestBody annonce updatedAnnonce) {
        annonce annonce;
        try {
            annonce = annonceService.updateAnnonce(id, updatedAnnonce);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().body(annonce);
    }
}
