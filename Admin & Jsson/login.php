<?php
require_once('dbConnect.php');	
	
if($_SERVER['REQUEST_METHOD']=='POST') {
  $response = array();
   $list = $_POST['list'];
  $username = $_POST['username'];
  $password = $_POST['password'];
  
  $sql = "SELECT * FROM alternatif,hasil where alternatif.username ='$username' and alternatif.password = '$password' and hasil.list='$list' and hasil.status='Lulus'";
   $sql2 = "SELECT * FROM alternatif,hasil where alternatif.username ='$username' and alternatif.password = '$password' and hasil.list='$list' and hasil.status='Tidak Lulus'";
  $res = mysqli_fetch_array(mysqli_query($con,$sql));
  $res1 = mysqli_query($con,$sql);
  $res2 = mysqli_fetch_array(mysqli_query($con,$sql2));
  $res3 = mysqli_query($con,$sql2);
  if(isset($res)){
	   while($row = mysqli_fetch_array($res1)){
    array_push($response, array('username'=>$row[5], 'nama_alternatif'=>$row[3],'password'=>$row[6],));
    $_SESSION['username']=$row['6'];
 echo json_encode(array("value"=>1 ,"message"=>'sukses login!',"result"=>$response));
	   }
  }
	else if(isset($res2)){
	   while($row = mysqli_fetch_array($res3)){
    array_push($response, array('username'=>$row[5], 'nama_alternatif'=>$row[3],'password'=>$row[6],));
    $_SESSION['username']=$row['6'];
 echo json_encode(array("value"=>"false" ,"message"=>'sukses login!',"result"=>$response));
	   }
}else {
       $response["value"] = 0;
       $response["message"] = "Username Atau Password Salah";
       echo json_encode($response);
   }
  

  mysqli_close($con);
}
