//
//  ViewController.m
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import "ViewController.h"
#import "LoginViewController.h"
#import "RegisterViewController.h"
@interface ViewController ()<BMKMapViewDelegate>
{
    BMKMapView *_mapView;
}

@end

@implementation ViewController

-(void)viewWillAppear:(BOOL)animated
{
    [_mapView viewWillAppear];
    _mapView.delegate = self; // 此处记得不用的时候需要置nil，否则影响内存的释放
}
-(void)viewWillDisappear:(BOOL)animated
{
    [_mapView viewWillDisappear];
    _mapView.delegate = nil; // 不用时，置nil
}

- (void)viewDidLoad {
    [super viewDidLoad];
    self.view.backgroundColor = [UIColor yellowColor];
    
    
    UIButton *loginButton = [UIButton buttonWithType:UIButtonTypeSystem];
    loginButton.frame = CGRectMake(100, 100, 100, 100);
    loginButton.backgroundColor = [UIColor blackColor];
    [loginButton addTarget:self action:@selector(goLgoin) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:loginButton];
    
    BMKMapView *view = [[BMKMapView alloc]init];
    view.frame = CGRectMake(100, 200, 200, 200);
    [self.view addSubview:view];
    
    
    // Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)goLgoin
{
    LoginViewController *vc = [[LoginViewController alloc]init];
    [self.navigationController pushViewController:vc animated:YES];
}

@end
