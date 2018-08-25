<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::get('/demo', function () {
//    $content = getenv('TEST');
    $vcap_application = json_decode($_ENV["VCAP_APPLICATION"]);
    $content = $vcap_application->{'application_id'};
    $type = 'text/plain;charset=UTF-8';
    return response($content)
        ->withHeaders([
            'Content-Type' => $type
        ]);
});
