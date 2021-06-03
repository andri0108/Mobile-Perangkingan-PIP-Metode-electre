<?php

if($_SERVER['REQUEST_METHOD']=='POST') {

   $response = array();
   //mendapatkan data
  
   $kode_alternatif = $_POST['kode_alternatif'];
   $id_KIP = $_POST['id_KIP'];
   $nama_alternatif = $_POST['nama_alternatif'];
   $asal_sekolah = $_POST['asal_sekolah'];
    $username = $_POST['username'];
     $password = $_POST['password'];
     $tanggal=$_POST['tanggal_input'];
     $tanggal=date('Y-m-d');
     
      
   

   require_once('dbConnect.php');
   //Cek npm sudah terdaftar apa belum
   $sql = "SELECT * FROM alternatif WHERE kode_alternatif ='$kode_alternatif'";
   $check = mysqli_fetch_array(mysqli_query($con,$sql));
   if(isset($check)){
     $response["value"] = 0;
     $response["message"] = "oops! NPM sudah terdaftar!";
     echo json_encode($response);
   } else {
     $sql = "INSERT INTO alternatif (kode_alternatif,id_KIP,nama_alternatif,asal_sekolah,username,password,tanggal_input) VALUES('$kode_alternatif','$id_KIP','$nama_alternatif','$asal_sekolah','$username','$password','$tanggal')";
     if(mysqli_query($con,$sql)) {
       $response["value"] = 1;
       $response["message"] = "Sukses mendaftar";
       echo json_encode($response);
     } else {
       $response["value"] = 0;
       $response["message"] = "oops! Coba lagi!";
       echo json_encode($response);
     }
   }
   // tutup database
   mysqli_close($con);
} else {
  $response["value"] = 0;
  $response["message"] = "oops! sjdisjdsjd";
  echo json_encode($response);
}
